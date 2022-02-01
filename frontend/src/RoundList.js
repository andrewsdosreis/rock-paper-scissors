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
import React from "react";

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

export default function RoundList(props) {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Container className={classes.container} maxWidth="lg">
        <Paper className={classes.paper}>
          <Box display="flex">
            <Box flexGrow={1}>
              <Typography component="h2" variant="h6" color="primary" gutterBottom>
                ROUNDS PLAYED IN THIS SESSION: {props.rounds.length}
              </Typography>
            </Box>
            <Box>
              <Button variant="contained" onClick={() => props.action()} color="primary">
                RESTART GAME
              </Button>
            </Box>
          </Box>
          <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="simple table">
              <TableHead>
                <TableRow>
                  <TableCell align="left"><b>PLAYER ONE</b></TableCell>
                  <TableCell align="left"><b>PLAYER TWO</b></TableCell>
                  <TableCell align="left"><b>RESULT</b></TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {props.rounds.map((round) => (
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