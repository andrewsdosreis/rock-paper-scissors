import { Table } from '@material-ui/core';
import Box from '@material-ui/core/Box';
import Container from '@material-ui/core/Container';
import Paper from '@material-ui/core/Paper';
import { makeStyles } from '@material-ui/core/styles';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
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

export default function TotalGamesPlayed(props) {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Container className={classes.container} maxWidth="lg">
        <Paper className={classes.paper}>
          <Box display="flex">
            <Box flexGrow={1}>
              <Typography component="h2" variant="h6" color="primary" gutterBottom>
                TOTAL GAMES PLAYED
              </Typography>
            </Box>
          </Box>
          <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="simple table">
              <TableHead>
                <TableRow>
                  <TableCell align="left">TOTAL GAMES PLAYED</TableCell>
                  <TableCell align="left">TOTAL PLAYER ONE WINS</TableCell>
                  <TableCell align="left">TOTAL PLAYER TWO WINS</TableCell>
                  <TableCell align="left">TOTAL DRAWS</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                <TableRow>
                  <TableCell align="left">{props.totalGamesPlayed.totalRoundsPlayed}</TableCell>
                  <TableCell align="left">{props.totalGamesPlayed.totalWinsForPlayerOne}</TableCell>
                  <TableCell align="left">{props.totalGamesPlayed.totalWinsForPlayerTwo}</TableCell>
                  <TableCell align="left">{props.totalGamesPlayed.totalDraws}</TableCell>
                </TableRow>
              </TableBody>
            </Table>
          </TableContainer>
        </Paper>
      </ Container>
    </div>
  );
}