import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { Sale } from '../models/sale';
import { Message } from '../models/util';

const INITIAL_SALES: Sale[] = [

];

const INITIAL_MESSAGE: Message = {
    text: null
};

const salesSlice = createSlice({
    name: "sales",
    initialState: INITIAL_SALES,
    reducers: {
        setSales(state, {payload}: PayloadAction<Sale[]>) {
            return [...payload];
        },
        addSale(state, { payload }: PayloadAction<Sale>) {
            return [...state, {...payload}]
        },
        removeSale(state, action: PayloadAction<Sale>) {
            return state.filter((sale) => sale.id !== action.payload.id);
        }
    }
});

const messageSlice = createSlice({
    name: 'message',
    initialState: INITIAL_MESSAGE,
    reducers: {
        setMessage(state, { payload }: PayloadAction<string>) {
            return {...state, text: payload };
        },
        clearMessage(state) {
            return {...state, text: null};
        }
    }
});

export const selectSales = (state: any) => {
    return state.sales as Sale[];
}

export const selectMessage = (state: any) => {
    return state.message as Message;
}

export const salesReducer = salesSlice.reducer;
export const messageReducer = messageSlice.reducer;

export const { addSale, setSales, removeSale } = salesSlice.actions;
export const { setMessage, clearMessage } = messageSlice.actions;