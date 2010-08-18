package org.springframework.persistence.graph;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.persistence.graph.neo4j.NodeBacked;

public @interface Graph {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface Entity {
		
		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.FIELD)
		public @interface Relationship {
			
			String type();
			
			Direction direction();

			Class<? extends NodeBacked> elementClass() default NodeBacked.class;	
		}
		
		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.FIELD)
		public @interface RelationshipEntity {
			String type();
			
			Direction direction();
		}
		
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface Relationship {
		
		String type() default "";
		
		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.FIELD)
		public @interface StartNode {
		}

		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.FIELD)
		public @interface EndNode {
		}
		
	}
	
}
