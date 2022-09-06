import './style.css'

import NotificationButton from '../NotificationButton';

import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useState } from 'react';

export default function () {

    const initialDate = new Date(new Date().setDate(new Date().getDate() - 365));

    const [ minDate, setMinDate ] = useState(initialDate);
    const [ maxDate, setMaxDate ] = useState(new Date());

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
                        <tr>
                            <td className="show992">#341</td>
                            <td className="show576">08/07/2022</td>
                            <td>Anakin</td>
                            <td className="show992">15</td>
                            <td className="show992">11</td>
                            <td>R$ 55300.00</td>
                            <td>
                                <div className="dsmeta-red-btn-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                    </tbody>

                </table>
            </div>

        </div>
    )
}