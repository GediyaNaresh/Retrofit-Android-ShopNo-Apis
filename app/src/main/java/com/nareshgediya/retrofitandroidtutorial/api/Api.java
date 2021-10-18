package com.nareshgediya.retrofitandroidtutorial.api;

import com.nareshgediya.retrofitandroidtutorial.models.AllProductData;
import com.nareshgediya.retrofitandroidtutorial.models.AllProductResponse;
import com.nareshgediya.retrofitandroidtutorial.models.CartResponse;
import com.nareshgediya.retrofitandroidtutorial.models.CategoryResponse;
import com.nareshgediya.retrofitandroidtutorial.models.DefaultResponse;
import com.nareshgediya.retrofitandroidtutorial.models.HomePage;
import com.nareshgediya.retrofitandroidtutorial.models.Login2Response;

import com.nareshgediya.retrofitandroidtutorial.models.LoginResponse;
import com.nareshgediya.retrofitandroidtutorial.models.DResponse;
import com.nareshgediya.retrofitandroidtutorial.models.OrderProduct;
import com.nareshgediya.retrofitandroidtutorial.models.OrderResponse;
import com.nareshgediya.retrofitandroidtutorial.models.SingleProduct;
import com.nareshgediya.retrofitandroidtutorial.models.SubcategoryProduct;
import com.nareshgediya.retrofitandroidtutorial.models.UsersResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {


    @FormUrlEncoded
    @POST("createuser")
    Call<DefaultResponse> createUser(
            @Field("email") String email,
            @Field("password") String password,
            @Field("name") String name,
            @Field("school") String school
    );

//    @FormUrlEncoded
//    @POST("userlogin")
//    Call<LoginResponse> userLogin(
//            @Field("email") String email,
//            @Field("password") String password
//    );

    @FormUrlEncoded
    @POST("user_login")
    Call<Login2Response> userLogin(
            @Field("email") String email,
            @Field("pass") String pass
    );

    @FormUrlEncoded
    @POST("home_page")
    Call<HomePage> getHomePage(
            @Field("user_id") int user_id);

    @FormUrlEncoded
    @POST("get_my_cart")
    Call<CartResponse> getCartList(
            @Field("user_id") int user_id);

    @FormUrlEncoded
    @POST("my_pending_order")
    Call<OrderResponse> getPendingOrder(
            @Field("user_id") int user_id);


    @FormUrlEncoded
    @POST("single_product")
    Call<SingleProduct> getSingleProduct(
            @Field("product_id") String product_id);

    @FormUrlEncoded
    @POST("category_wise_product")
    Call<CategoryResponse> getCategoryWiseProduct(
            @Field("cid") String cid);

    @FormUrlEncoded
    @POST("add_to_cart")
    Call<DResponse> addTocart(
            @Field("pro_id") String pro_id,
            @Field("user_id") String user_id,
            @Field("qty") String qty
    );

    @FormUrlEncoded
    @POST("remove_my_cart")
    Call<DResponse> removeFromCart(
            @Field("pro_id") String pro_id,
            @Field("user_id") String user_id
    );


    @FormUrlEncoded
    @POST("view_all_product")
    Call<AllProductResponse> getAllProduct(
            @Field("sort_by") String sort_by,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("subcategory_wise_product")
    Call<SubcategoryProduct> getSubCategoryWiseProduct(
            @Field("sid") String sid);

    @GET("allusers")
    Call<UsersResponse> getUsers();

    @FormUrlEncoded
    @PUT("updateuser/{id}")
    Call<LoginResponse> updateUser(
            @Path("id") int id,
            @Field("email") String email,
            @Field("name") String name,
            @Field("school") String school
    );

    @FormUrlEncoded
    @PUT("updatepassword")
    Call<DefaultResponse> updatePassword(
            @Field("currentpassword") String currentpassword,
            @Field("newpassword") String newpassword,
            @Field("email") String email
    );

    @DELETE("deleteuser/{id}")
    Call<DefaultResponse> deleteUser(@Path("id") int id);

}
