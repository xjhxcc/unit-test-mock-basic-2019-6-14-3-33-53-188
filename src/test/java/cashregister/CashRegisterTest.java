package cashregister;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Printer printer=mock(Printer.class);
        CashRegister cashRegister=new CashRegister(printer);
        Item item=new Item("x",2.2);
        Purchase purchase=new Purchase(new Item []{item});
        //when
        cashRegister.process(purchase);
        //then
        verify(printer,times(1)).print("x\t2.2\n");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        Printer printer=mock(Printer.class);
        CashRegister cashRegister=new CashRegister(printer);
        Purchase purchase=mock(Purchase.class);
        when(purchase.asString()).thenReturn("jia");
        //when
        cashRegister.process(purchase);
        //then
        verify(printer,times(1)).print("jia");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        CashRegister mockCashRegister = mock(CashRegister.class);
        Item item=new Item("x",2.2);
        Item item2=new Item("y",14);
        Item []itemarr={item,item2};
        Purchase purchase=new Purchase(itemarr);
        //when
        mockCashRegister.process(purchase);
        mockCashRegister.process(purchase);
        //then
        verify(mockCashRegister,times(2)).process(purchase);
    }

}
