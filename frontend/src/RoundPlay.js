import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Container from '@material-ui/core/Container';
import Paper from '@material-ui/core/Paper';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import { default as React } from "react";

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

export default function RoundPlay() {
  const classes = useStyles();

  const Play = () => {
    var url = "http://localhost:8080/v1/rounds";

    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', '*/*');
    headers.append('Origin', 'http://localhost:3000');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('SESSION-KEY', 'OwkZLGZFJQRjBdzd19wCF3yS9kd22h');

    fetch(url, {
      mode: 'cors',
      method: 'POST',
      headers: headers
    }).then(
      (result) => {
        alert('Game Played')
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
                PLAY A ROUND!
              </Typography>
            </Box>
            <Box>
              <Button variant="contained" onClick={() => Play()} color="primary">
                PLAY
              </Button>
            </Box>
          </Box>
        </Paper>
      </ Container>
    </div>
  );
}