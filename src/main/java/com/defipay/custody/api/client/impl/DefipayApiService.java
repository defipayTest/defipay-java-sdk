package com.defipay.custody.api.client.impl;


import com.defipay.custody.api.client.domain.ApiResponse;
import com.defipay.custody.api.client.domain.response.*;
import com.defipay.custody.api.client.domain.response.external.ChainTokenInfoDTO;
import com.defipay.custody.api.client.domain.response.external.CoinApiAssetInfoDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface DefipayApiService {

    @FormUrlEncoded
    @POST("/v1/external/pay/create")
    Call<ApiResponse<CreateOrderResponse>> createOrder(@Field("notifyUrl") String notifyUrl, @Field("returnUrl") String returnUrl
                            ,@Field("memberTransNo") String memberTransNo, @Field("amount") String amount
                            ,@Field("currency") String currency, @Field("tokenIds") String tokenIds
                            ,@Field("makingUp") Boolean makingUp);
    

    @FormUrlEncoded
    @POST("/v1/external/pay/query")
    Call<ApiResponse<OrderQueryResponse>> queryOrder(@Field("memberTransNo") String memberTransNo, @Field("transNo") String transNo);

    @FormUrlEncoded
    @POST("/v1/external/payout/create")
    Call<ApiResponse<CreatePayoutOrderResponse>> createPayoutOrder(@Field("notifyUrl") String notifyUrl, @Field("memberTransNo") String memberTransNo
            , @Field("amount") String amount ,@Field("currency") String currency
            , @Field("toAddress") String toAddress
            , @Field("tokenId") Long tokenId
            ,@Field("payAmount") String payAmount);

    @FormUrlEncoded
    @POST("/v1/external/payout/query")
    Call<ApiResponse<PayoutOrderQueryResponse>> queryPayoutOrder();

    @FormUrlEncoded
    @POST("/v1/external/rate/query")
    Call<ApiResponse<RateDTO>> queryRate(@Field("base") String base ,@Field("quote") String quote);

    @FormUrlEncoded
    @POST("/v1/external/billCurrency/query")
    Call<ApiResponse<List<CoinApiAssetInfoDTO>>> queryBillCurrency(@Field("offset") Integer offset ,@Field("limit") Integer limit);

    @FormUrlEncoded
    @POST("/v1/external/token/query")
    Call<ApiResponse<List<ChainTokenInfoDTO>>> queryPayCurrency(@Field("offset") Integer offset ,@Field("limit") Integer limit);

    @GET("/v1/external/account/query")
    Call<ApiResponse<List<MemberUserVirtualAccountInfoResponse>>> queryCryptoAmount();
}