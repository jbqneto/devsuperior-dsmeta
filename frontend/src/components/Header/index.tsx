import './style.css'
import logo from '../../assets/img/logo.png'

export default function() {

    return (
    <header>
        <div className="dsmeta-logo-container">
            <img src={logo} alt="DSMeta" />
            <h1>DSMeta</h1>
            <p>
              Desenvolvido por
              <a href="https://www.linkedin.com/in/jbqneto">Jbqneto</a>
            </p>
        </div>
    </header>
    );
}