package com.dehrg.todos.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTask is a Querydsl query type for Task
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTask extends EntityPathBase<Task> {

    private static final long serialVersionUID = -179882198L;

    public static final QTask task = new QTask("task");

    public final BooleanPath complete = createBoolean("complete");

    public final StringPath name = createString("name");

    public final SetPath<Task, QTask> subTasks = this.<Task, QTask>createSet("subTasks", Task.class, QTask.class, PathInits.DIRECT2);

    public final NumberPath<Long> taskId = createNumber("taskId", Long.class);

    public final NumberPath<Integer> weight = createNumber("weight", Integer.class);

    public QTask(String variable) {
        super(Task.class, forVariable(variable));
    }

    public QTask(Path<? extends Task> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTask(PathMetadata<?> metadata) {
        super(Task.class, metadata);
    }

}

