package com.dehrg.todos.model.jpa;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTaskListJPA is a Querydsl query type for TaskListJPA
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTaskListJPA extends EntityPathBase<TaskListJPA> {

    private static final long serialVersionUID = 1864342720L;

    public static final QTaskListJPA taskListJPA = new QTaskListJPA("taskListJPA");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<TaskJPA, QTaskJPA> tasks = this.<TaskJPA, QTaskJPA>createSet("tasks", TaskJPA.class, QTaskJPA.class, PathInits.DIRECT2);

    public QTaskListJPA(String variable) {
        super(TaskListJPA.class, forVariable(variable));
    }

    public QTaskListJPA(Path<? extends TaskListJPA> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTaskListJPA(PathMetadata<?> metadata) {
        super(TaskListJPA.class, metadata);
    }

}

