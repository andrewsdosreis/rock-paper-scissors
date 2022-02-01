import React, { useEffect, useState } from "react";
import { BrowserRouter as Router } from "react-router-dom";
import Navbar from './Navbar';
import RoundList from './RoundList';
import RoundPlay from './RoundPlay';

export default function App() {
  const [roundPlayed, setRoundPlayed] = useState("");
  const [rounds, setRounds] = useState([]);
  
  useEffect(() => {
    RoundsGet()
  }, [roundPlayed])

  useEffect(() => {
    StartSession()
  }, [])

  const StartSession = () => {
    var url = "http://localhost:8080/v1/sessions";
    
    let headers = new Headers();
    
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');

    if (localStorage.getItem("SESSION-KEY") == null) {
      fetch(url, {
        mode: 'cors',
        method: 'GET',
        headers: headers
      }).then(res => res.json())
        .then(
          (responseBody) => {
            console.log('New Session Created!');
            localStorage.setItem("SESSION-KEY", responseBody.key);
          }
        )
    }
  }

  const Play = () => {
    var url = "http://localhost:8080/v1/rounds";

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('SESSION-KEY', localStorage.getItem("SESSION-KEY"));

    fetch(url, {
      mode: 'cors',
      method: 'POST',
      headers: headers
    }).then(res => res.json())
      .then(
        (responseBody) => {
          console.log('Game Played');
          setRoundPlayed(responseBody);
        }
      )
  }

  const RoundsGet = () => {
    var url = "http://localhost:8080/v1/rounds";

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('SESSION-KEY', localStorage.getItem("SESSION-KEY"));

    fetch(url, {
      mode: 'cors',
      method: 'GET',
      headers: headers
    }).then(res => res.json())
      .then(
        (result) => {
          setRounds(result);
        }
      )
  }

  const Restart = () => {
    var url = "http://localhost:8080/v1/rounds";

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('SESSION-KEY', localStorage.getItem("SESSION-KEY"));

    fetch(url, {
      mode: 'cors',
      method: 'DELETE',
      headers: headers
    }).then(
      () => {
        console.log('Session has been restarded');
        setRounds([]);
      }
    )
  }

  return (
    <Router>
      <Navbar />
      <RoundPlay roundPlayed={roundPlayed} action={Play} />
      <RoundList rounds={rounds} action={Restart} />
    </Router>
  );
}