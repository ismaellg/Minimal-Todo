import com.example.avjindersinghsekhon.minimaltodo.BuildConfig;
import com.example.avjindersinghsekhon.minimaltodo.Receipt;
import com.example.avjindersinghsekhon.minimaltodo.ReceiptApi;
import com.example.avjindersinghsekhon.minimaltodo.ReceiptInteractor;

import org.junit.Test;

import io.reactivex.Single;
import io.reactivex.functions.BiConsumer;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ismael on 6/13/17.
 */

public class ReceiptInteractorTest {

    @Test
    public void testGetReceipt() {
        ReceiptApi mock = mock(ReceiptApi.class);

        when(mock.getReceipt("", BuildConfig.MERCHANT_ID)).thenReturn(Single.just(new Receipt()));

        ReceiptInteractor interactor = new ReceiptInteractor(mock);

        assertNotNull(interactor.getReceipt("").blockingGet());
    }

    @Test
    public void testGetReceiptError() {
        ReceiptApi mock = mock(ReceiptApi.class);

        when(mock.getReceipt("", BuildConfig.MERCHANT_ID)).thenReturn(Single.<Receipt>error(new Exception()));

        ReceiptInteractor interactor = new ReceiptInteractor(mock);

        Single<Receipt> single = interactor.getReceipt("");

        single.subscribe(new BiConsumer<Receipt, Throwable>() {
            @Override
            public void accept(Receipt receipt, Throwable throwable) throws Exception {
                assertNull(receipt);

                assertNotNull(throwable);

                assertTrue(throwable.getClass() == Exception.class);
            }
        });
    }

}
