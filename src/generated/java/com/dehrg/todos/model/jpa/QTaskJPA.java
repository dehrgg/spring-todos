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

    public static final QTaskJPA taskJPA = new QTaskJPA("taskJPA");

    public final BooleanPath complete = createBoolean("complete");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<TaskJPA, QTaskJPA> subTasks = this.<TaskJPA, QTaskJPA>createSet("subTasks", TaskJPA.class, QTaskJPA.class, PathInits.DIRECT2);

    public final NumberPath<Integer> weight = createNumber("weight", Integer.class);

    public QTaskJPA(String variable) {
        super(TaskJPA.class, forVariable(variable));
    }

    public QTaskJPA(Path<? extends TaskJPA> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTaskJPA(PathMetadata<?> metadata) {
        super(TaskJPA.class, metadata);
    }

}

