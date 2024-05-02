package sg.edu.ntu.fnbapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.exception.ConsumerNotFoundException;
import sg.edu.ntu.fnbapi.repository.ConsumerRepository;

@SpringBootTest
public class ConsumerServiceImplTest {

    @Mock
    private ConsumerRepository consumerRepository;

    @InjectMocks
    ConsumerServiceImpl consumerService;

    @Test
    public void createConsumerTest() {
        //Setup
        Consumer consumer =  Consumer.builder().firstName("Paul").lastName("Low").email("paullow@outlook.com").build();

        when((consumerRepository.save(consumer))).thenReturn(consumer);

        //Execute
        Consumer saveConsumer = consumerService.createConsumer(consumer);

        //Assert
        assertEquals(consumer, saveConsumer, "The saved customer should be the same as the new customer");

        verify(consumerRepository, times(1)).save(consumer);
    }

    @Test
    public void getConsumerTest() {
        //Setup
        Consumer consumer = Consumer.builder().firstName("Paul").lastName("Low").email("paullow@outlook.com").build();

        Long consumerId = 5L;

        when(consumerRepository.findById(consumerId)).thenReturn(Optional.of(consumer));

        //Execute
        Consumer retrievedConsumer = consumerService.getConsumer(consumerId);

        //Assert
        assertEquals(consumer, retrievedConsumer);

    }

    @Test
    public void testGetConsumerNotFound() {
        Long consumerId = 1L;
        when(consumerRepository.findById(consumerId)).thenReturn(Optional.empty());

        assertThrows(ConsumerNotFoundException.class, () -> consumerService.getConsumer(consumerId));
    }

}
