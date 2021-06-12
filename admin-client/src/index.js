import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";


ReactDOM.render(
  <React.StrictMode>
    <AppBar position="static">
      <Toolbar style={{ alignSelf: "center" }}>
        <Typography variant="h6">
          IQAS - Intelligent Question Answering System
        </Typography>
      </Toolbar>
    </AppBar>
    <Container maxWidth="sm" style={{ textAlign: "center" }}>
      <p style={{ fontSize: "xx-large", fontWeight: "bold" }}>
        Submit your text
      </p>
    </Container>
    <App />
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
