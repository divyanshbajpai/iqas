import "./App.css";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import React, { useReducer, useState } from "react";

const formReducer = (state, event) => {
  if (event.reset) {
    return {
      name:"",
      text: ""
    };
  }
  return {
    ...state,
    [event.name]: event.value,
  };
};

function App() {
  const [formData, setFormData] = useReducer(formReducer, {});
  const [doc, setDoc] = useState({
    name: "",
    text: ""
  });
  const [suc, setSuc] = useState({});

  const handleChange = (event) => {
    setFormData({
      name: event.target.name,
      value: event.target.value,
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log(JSON.stringify(formData));
    const getData = await fetch("http://localhost:5000/api/kb/1/doc/", {
      method: "POST",
      body: JSON.stringify(formData),
      headers: {
        "Content-Type": "application/json"
      },
    });
    const resData = await getData.json();
    const success= getData.status;
    console.log(resData);
    console.log(getData.status);
    setDoc(resData);
    setSuc(success);
    // event.target.reset();
  };

  const showAnswer = () => {
    if (suc !== 200) return null;
    else
      return (
        <div>
          <p>Success</p>
        </div>
      );
  };



  return (
    <div className="App">
      <Container maxWidth="xl">
        <form onSubmit={handleSubmit}>
          <Container>
            <TextField
              required
              id="standard-required"
              label="Required"
              defaultValue="Doc"
              style={{paddingBottom:'20px'}}
              name="name"
              onChange={handleChange}
            />
          </Container>
          <TextField
            id="outlined-multiline-static-required"
            label="Enter your text"
            multiline
            rows={9}
            style={{ width: "60%", paddingTop: "20px" }}
            variant="outlined"
            name="text"
            onChange={handleChange}
          />
          <Container maxWidth="sm" style={{ paddingTop: "20px" }}>
            <Button variant="contained" color="primary" type="submit">
              Submit
            </Button>
          </Container>
        </form>
      </Container>
      <Container>
        {showAnswer()}
      </Container>
    </div>
  );
}

export default App;
