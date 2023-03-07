package ir.truelearn.androidmvvmsample.util

import android.app.Activity
import android.util.Log
import com.zarinpal.ZarinPalBillingClient
import com.zarinpal.billing.purchase.Purchase
import com.zarinpal.client.BillingClientStateListener
import com.zarinpal.client.ClientState
import com.zarinpal.provider.core.future.FutureCompletionListener
import com.zarinpal.provider.core.future.TaskResult
import com.zarinpal.provider.model.response.Receipt
import ir.truelearn.androidmvvmsample.MainActivity
import ir.truelearn.androidmvvmsample.util.Constants.ZARINPAL_MERCHANT_ID
import java.text.DecimalFormat
import java.time.temporal.TemporalAmount

object ZarinpalPurchase {

    private val stateListener = object : BillingClientStateListener {
        override fun onClientSetupFinished(state: ClientState) {
            //Observing client states
        }

        override fun onClientServiceDisconnected() {
            Log.e("3636", "Billing client Disconnected")
            //When Service disconnect
        }
    }

    fun purchase(
        activity: Activity,
        amount: Long,
        description: String,
        action: (String) -> Unit
    ) {
        val client = ZarinPalBillingClient.newBuilder(activity)
            .enableShowInvoice()
            .setListener(stateListener)
            .build()

        val purchase = Purchase.newBuilder()
            .asPaymentRequest(
                ZARINPAL_MERCHANT_ID,
                amount,
                "https://truelearn.ir/",
                description
            ).build()

        client.launchBillingFlow(purchase,
            object : FutureCompletionListener<Receipt> {
                override fun onComplete(task: TaskResult<Receipt>) {
                    if (task.isSuccess) {
                        val receipt = task.success
                        receipt?.transactionID?.let {
                            Log.e("3636", it)
                            action(it)
                        }

                        //here you can send receipt data to your server
                        //sentToServer(receipt)

                    } else {
                        task.failure?.printStackTrace()
                    }
                }
            })
    }


}