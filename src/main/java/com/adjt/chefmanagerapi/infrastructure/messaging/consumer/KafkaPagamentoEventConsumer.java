package com.adjt.chefmanagerapi.infrastructure.messaging.consumer;

import com.adjt.chefmanagerapi.core.gateways.interfaces.PagamentoEventConsumer;
import com.adjt.chefmanagerapi.core.usecases.pedido.atualizar.AtualizarPedido;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

import java.util.logging.Logger;

public class KafkaPagamentoEventConsumer implements PagamentoEventConsumer {

    private final AtualizarPedido atualizarPedido;
    private final Logger logger = Logger.getLogger(KafkaPagamentoEventConsumer.class.getName());

    public KafkaPagamentoEventConsumer(AtualizarPedido atualizarPedido) {
        this.atualizarPedido = atualizarPedido;
    }

    @Override
    public void notificaPagamentoAprovado(EventoPagamentoAprovadoMessageInput input) {
        atualizarPedido.executar(EventoPagamentoAprovadoMessageMapper.toInput(input));
    }

    @Override
    public void notificaPagamentoPendente(EventoPagamentoPendenteMessageInput input) {
        atualizarPedido.executar(EventoPagamentoPendenteMessageMapper.toInput(input));
    }

    @KafkaListener(topics = "pagamento.aprovado", groupId = "pagamentos")
    public void listenPagamentoAprovado(EventoPagamentoAprovadoMessageInput input, Acknowledgment ack) {
        try {
            notificaPagamentoAprovado(input);
            ack.acknowledge();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    @KafkaListener(topics = "pagamento.pendente", groupId = "pagamentos")
    public void listenPagamentoPendente(EventoPagamentoPendenteMessageInput input, Acknowledgment ack) {
        try {
            notificaPagamentoPendente(input);
            ack.acknowledge();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
