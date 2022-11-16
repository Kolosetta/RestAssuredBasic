package services;

import io.restassured.http.Cookies;

public class OrderService extends BaseService{

    public OrderService(Cookies cookies) {
        super(cookies);
    }

    @Override
    protected String getBasePath() {
        return "/orders";
    }
}
