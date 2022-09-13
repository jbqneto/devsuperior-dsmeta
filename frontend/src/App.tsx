import { useEffect } from "react";
import { useSelector } from "react-redux";
import Header from "./components/Header";
import SalesCard from "./components/SalesCard";
import { selectMessage } from "./redux/action";

import { toast, ToastContainer } from "react-toastify"
import 'react-toastify/dist/ReactToastify.css';

function App() {
  
  const message = useSelector(selectMessage);

  useEffect(() => {

    if (message.text) {
      toast.info(message.text);
    }

  }, [message]);

  return (
    <div>
        <ToastContainer />
        <Header/>
        <main>
          <section id="sales">
            <div className="dsmeta-container">
              <SalesCard />
            </div>
          </section>
        </main>
    </div>
  )

}

export default App
