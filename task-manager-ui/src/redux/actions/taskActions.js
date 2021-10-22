import { ActionTypes } from "../constants/action-types";

export const setTasks = (tasks) => {
    return {
        type: ActionTypes.SET_TASKS,
        payload: tasks,
    };
};

export const taskCreate = (task) => {
    return {
        type: ActionTypes.CREATE_TASK,
        payload: task,
    };
};

export const selectedTask = (task) => {
    return {
        type: ActionTypes.SELECTED_TASK,
        payload: task,
    };
};

export const removeSelectedTask = () => {
    return {
        type: ActionTypes.REMOVE_SELECTED_TASK,
    };
};