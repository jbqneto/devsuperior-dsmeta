import './style.css';

import NotificationButton from '../NotificationButton';

import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from '../../config/request';
import { selectSales, setMessage, setSales } from '../../redux/action';
import { useDispatch, useSelector } from 'react-redux';

export default function () {

    const initialDate = new Date(new Date().setDate(new Date().getDate() - 365));

    const [ minDate, setMinDate ] = useState(initialDate);
    const [ maxDate, setMaxDate ] = useState(new Date());
    
    const sales = useSelector(selectSales);
    const dispatch = useDispatch();

    useEffect(() => {

        const dateMin = minDate.toISOString().slice(0, 10);
        const dateMax = maxDate.toISOString().slice(0, 10);
        
        axios.get(`${BASE_URL}/sales?minDate=${dateMin}&maxDate=${dateMax}`).then(({ data }) => {
            dispatch(setSales(data.content))
        })

    }, [minDate, maxDate]);

    return (
        <div className="dsmeta-card">
            <h2 className="dsmeta-sales-title">Vendas</h2>
            <div>
                <div className="dsmeta-form-control-container">
                    <DatePicker className='dsmeta-form-control'
                        selected={minDate}
                        onSelect={() => { }}
                        onChange={(value: Date) => { setMinDate(value); }}
                    />
                </div>
                <div className="dsmeta-form-control-container">
                    <DatePicker className='dsmeta-form-control'
                        selected={maxDate}
                        onSelect={() => { }}
                        onChange={(value: Date) => { setMaxDate(value); }}
                    />
                </div>
            </div>

            <div>
                <table className="dsmeta-sales-table">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Data</th>
                            <th>Vendedor</th>
                            <th className="show992">Visitas</th>
                            <th className="show992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            sales.map((sale) => {

                                return (
                                    <tr key={sale.id}>
                                        <td className="show992">{sale.id}</td>
                                        <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                                        <td>{sale.sellerName}</td>
                                        <td className="show992">{sale.visited}</td>
                                        <td className="show992">{sale.deals}</td>
                                        <td>R$ {sale.amount.toFixed(2)}</td>
                                        <td>
                                            <div className="dsmeta-red-btn-container notify-container">
                                                <NotificationButton saleId={sale.id} />
                                            </div>
                                        </td>
                                    </tr>
                            )
                        })
                    }
                    </tbody>

                </table>
            </div>

        </div>
    )
}