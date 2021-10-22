import { combineReducers } from "redux";
import { selectedTasksReducer, taskReducer } from "./taskReducer";

const reducers = combineReducers({
    allTasks: taskReducer,
    task: selectedTasksReducer,
});

export default reducers;