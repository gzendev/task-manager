import React from "react";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";

const Task = () => {
    const tasks = useSelector((state) => state.allTasks.tasks);
    const renderList = tasks.map((task) => {
    const { id, title, status } = task;
    return (
        <div className="four wide column" key={id}>
            <Link to={`/task/${id}`}>
                <div className="ui link cards">
                    <div className="card">
                        <div className="content">
                            <div className="header">{title}</div>
                            <div>{status}</div>
                        </div>
                    </div>
                </div>
            </Link>
        </div>
        );
    });
    return <>{renderList}</>;
};

export default Task;