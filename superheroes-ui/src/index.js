import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Batman from "./images/1.jpeg";
import Superman from "./images/2.jpeg";
import GreenLantern from "./images/4.jpeg";
import TheHuntress from "./images/5.jpeg";
import TheFlash from "./images/3.jpeg";
import HarleyQuinn from "./images/6.jpeg";
import Deadshot from "./images/7.jpeg";
import CountVertigo from "./images/8.jpeg";
import Robin from "./images/9.jpeg";
import Nightwing from "./images/10.jpeg";

const images = {
    Batman,
    Superman,
    GreenLantern,
    TheHuntress,
    TheFlash,
    HarleyQuinn,
    Deadshot,
    CountVertigo,
    Robin,
    Nightwing
}
export default images;

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
