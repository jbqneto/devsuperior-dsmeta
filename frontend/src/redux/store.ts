import { configureStore } from "@reduxjs/toolkit";
import { salesReducer, messageReducer } from "./action";

const store = configureStore({
    reducer: {
        sales: salesReducer,
        message: messageReducer
    }
});

export default store;