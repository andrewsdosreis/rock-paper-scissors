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
    StartSession()
  }, [])

  useEffect(() => {
    RoundsGet()
  }, [roundPlayed])

  useEffect(() => {
    GetTotalGamesPlayed()
  }, [rounds])

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
            localStorage.setItem("SESSION-KEY", responseBody.key);
          }
        )
    }
  }

  const RoundsGet = () => {
    var requestUrl = url.baseUrl + url.v1.rounds;

    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');

    if (localStorage.getItem("SESSION-KEY") != null)
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
      ).catch(error => window.location.href="/");
  }

  const Play = () => {
    var requestUrl = url.baseUrl + url.v1.rounds;

    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');

    if (localStorage.getItem("SESSION-KEY") != null)
      headers.append('SESSION-KEY', localStorage.getItem("SESSION-KEY"));

    fetch(requestUrl, {
      mode: 'cors',
      method: 'POST',
      headers: headers
    }).then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error('Something went wrong during the play\nPlease refresh the page');
      }
    }).then(
      (responseBody) => {
        setRoundPlayed(responseBody);
      }
    ).catch(error => alert(error));
  }

  const Restart = () => {
    var requestUrl = url.baseUrl + url.v1.rounds;

    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');

    if (localStorage.getItem("SESSION-KEY") != null)
      headers.append('SESSION-KEY', localStorage.getItem("SESSION-KEY"));

    fetch(requestUrl, {
      mode: 'cors',
      method: 'DELETE',
      headers: headers
    }).then((response) => {
      if (response.ok) {
        return true;
      } else {
        throw new Error('Something went wrong trying to restart the session\nPlease refresh the page');
      }
    }).then(
      () => {
        setRounds([]);
      }
    ).catch(error => alert(error));
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