import React from "react";
import { BrowserRouter as Router } from "react-router-dom";
import Navbar from './Navbar';
import RoundList from './RoundList';
import RoundPlay from './RoundPlay';


export default function App() {
  return (
    <Router>
      <Navbar />
      <RoundPlay />
      <RoundList />
    </Router>
  );
}