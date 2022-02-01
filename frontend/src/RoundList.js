import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Container from '@material-ui/core/Container';
import Paper from '@material-ui/core/Paper';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Typography from '@material-ui/core/Typography';
import React, { useEffect, useState } from "react";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
  container: {
    marginTop: theme.spacing(2),
  },
  paper: {
    padding: theme.spacing(2),
    color: theme.palette.text.secondary,
  },
}));

export default function RoundList() {
  const classes = useStyles();

  const [rounds, setRounds] = useState([]);
  useEffect(() => {
    RoundsGet()
  }, [])

  const RoundsGet = () => {
    var url = "http://localhost:8080/v1/rounds";

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('SESSION-KEY', 'OwkZLGZFJQRjBdzd19wCF3yS9kd22h');

    fetch(url, {
      mode: 'cors',
      method: 'GET',
      headers: headers
    })
      .then(res => res.json())
      .then(
        (result) => {
          setRounds(result)
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
    headers.append('SESSION-KEY', 'OwkZLGZFJQRjBdzd19wCF3yS9kd22h');

    fetch(url, {
      mode: 'cors',
      method: 'DELETE',
      headers: headers
    }).then(
      () => {
        alert('Session has been restarded')
      }
    )

    window.location.href = '/';
  }

  return (
    <div className={classes.root}>
      <Container className={classes.container} maxWidth="lg">
        <Paper className={classes.paper}>
          <Box display="flex">
            <Box flexGrow={1}>
              <Typography component="h2" variant="h6" color="primary" gutterBottom>
                ROUNDS PLAYED
              </Typography>
            </Box>
            <Box>
              <Button variant="contained" onClick={() => Restart()} color="primary">
                RESTART
              </Button>
            </Box>
          </Box>
          <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="simple table">
              <TableHead>
                <TableRow>
                  <TableCell align="left">PLAYER ONE</TableCell>
                  <TableCell align="left">PLAYER TWO</TableCell>
                  <TableCell align="left">RESULT</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {rounds.map((round) => (
                  <TableRow>
                    <TableCell align="left">{round.playerOne}</TableCell>
                    <TableCell align="left">{round.playerTwo}</TableCell>
                    <TableCell align="left">{round.result}</TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
        </Paper>
      </Container>
    </div>
  );
}