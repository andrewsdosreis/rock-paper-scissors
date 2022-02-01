import React, { useEffect, useState } from "react";
import { BrowserRouter as Router } from "react-router-dom";
import { url } from "./ExternalApiConfig";
import Navbar from './Navbar';
import RoundList from './RoundList';
import RoundPlay from './RoundPlay';
import TotalGamesPlayed from './TotalGamesPlayed';

export default function App() {
  const [roundPlayed, setRoundPlayed] = useState("");
  const [rounds, setRounds] = useState([]);
  const [totalGamesPlayed, setTotalGamesPlayed] = useState("");

  useEffect(() => {
    RoundsGet()
  }, [roundPlayed])

  useEffect(() => {
    GetTotalGamesPlayed()
  }, [roundPlayed, rounds])

  useEffect(() => {
    StartSession()
  }, [])

  const StartSession = () => {
    var requestUrl = url.baseUrl + url.v1.sessions;
    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');

    if (localStorage.getItem("SESSION-KEY") == null) {
      fetch(requestUrl, {
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
    var requestUrl = url.baseUrl + url.v1.rounds;

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('SESSION-KEY', localStorage.getItem("SESSION-KEY"));

    fetch(requestUrl, {
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
    var requestUrl = url.baseUrl + url.v1.rounds;

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('SESSION-KEY', localStorage.getItem("SESSION-KEY"));

    fetch(requestUrl, {
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
    var requestUrl = url.baseUrl + url.v1.rounds;

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('SESSION-KEY', localStorage.getItem("SESSION-KEY"));

    fetch(requestUrl, {
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

  const GetTotalGamesPlayed = () => {
    var requestUrl = url.baseUrl + url.v1.total_games_played;

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');

    fetch(requestUrl, {
      mode: 'cors',
      method: 'GET',
      headers: headers
    }).then(res => res.json())
      .then(
        (responseBody) => {
          setTotalGamesPlayed(responseBody);
        }
      )
  }

  return (
    <Router>
      <Navbar />
      <RoundPlay roundPlayed={roundPlayed} action={Play} />
      <RoundList rounds={rounds} action={Restart} />
      <TotalGamesPlayed totalGamesPlayed={totalGamesPlayed} />
    </Router>
  );
}