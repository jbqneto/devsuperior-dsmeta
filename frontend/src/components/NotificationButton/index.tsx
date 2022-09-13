import axios from 'axios';
import { useDispatch } from 'react-redux';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../config/request';
import { setMessage } from '../../redux/action';

type Props = {
  saleId: number;
}

function NotificationButton({ saleId } : Props) {

    const dispatch = useDispatch();

    function handleNotifyClick(saleId: number): void {
      axios.get(`${BASE_URL}/sales/${saleId}/notification`).then(() => {
        dispatch(setMessage('Mensagem enviada com sucesso!'));
      });
    }
  
    return (
      <div className="dsmeta-red-btn notify-btn" onClick={() => handleNotifyClick(saleId)}>
        <img src={icon} alt="Notificar" />
      </div>
    )
}

export default NotificationButton;