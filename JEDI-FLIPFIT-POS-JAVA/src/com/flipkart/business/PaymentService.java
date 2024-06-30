package com.flipkart.business;

import com.flipkart.bean.Payment;

public class PaymentService {

      Payment payment = new Payment();

      public void createPayment(int transactionId, int cardNumber, String expiryDate, String modeOfPayment)
      {
            payment.setTransactionId(transactionId);
            payment.setCardNumber(cardNumber);
            payment.setExpiryDate(expiryDate);
            payment.setModeOfPayment(modeOfPayment);

            System.out.println("Payment Successful!");
      }

}
