package com.dehrg.todos.model.jpa;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTaskJPA is a Querydsl query type for TaskJPA
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTaskJPA extends EntityPathBase<TaskJPA> {

    private static final long serialVersionUID = 1048812478L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTaskJPA taskJPA = new QTaskJPA("taskJPA");

    public final DateTimePath<java.util.Calendar> actualFinishDate = createDateTime("actualFinishDate", java.util.Calendar.class);

    public final BooleanPath complete = createBoolean("complete");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SimplePath<com.dehrg.todos.model.Task> parent = createSimple("parent", com.dehrg.todos.model.Task.class);

    public final DateTimePath<java.util.Calendar> plannedFinishDate = createDateTime("plannedFinishDate", java.util.Calendar.class);

    public final SetPath<TaskJPA, QTaskJPA> subTasks = this.<TaskJPA, QTaskJPA>createSet("subTasks", TaskJPA.class, QTaskJPA.class, PathInits.DIRECT2);

    public final QTaskListJPA taskList;

    public final NumberPath<Integer> weight = createNumber("weight", Integer.class);

    public QTaskJPA(String variable) {
        this(TaskJPA.class, forVariable(variable), INITS);
    }

    public QTaskJPA(Path<? extends TaskJPA> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTaskJPA(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTaskJPA(PathMetadata<?> metadata, PathInits inits) {
        this(TaskJPA.class, metadata, inits);
    }

    public QTaskJPA(Class<? extends TaskJPA> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.taskList = inits.isInitialized("taskList") ? new QTaskListJPA(forProperty("taskList")) : null;
    }

}

