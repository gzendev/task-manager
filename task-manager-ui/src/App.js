import './App.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Header from "./components/Header"
import TaskDetail from './components/TaskDetail';
import TaskListing from './components/TaskListing';

function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <Switch>
          <Route path="/" exact component={TaskListing} />
          <Route path="/task/:taskId" exact component={TaskDetail} />
          <Route>404 Not Found!</Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
