package com.rtest.rutils.nifi;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "message", "condition" })
public class Rule implements Serializable {

	@JsonProperty("message")
	private String message;
	@JsonProperty("condition")
	private Condition condition;
	private final static long serialVersionUID = 1855984991975959046L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Rule() {
	}

	/**
	 *
	 * @param condition
	 * @param message
	 */
	public Rule(String message, Condition condition) {
		super();
		this.message = message;
		this.condition = condition;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	public Rule withMessage(String message) {
		this.message = message;
		return this;
	}

	@JsonProperty("condition")
	public Condition getCondition() {
		return condition;
	}

	@JsonProperty("condition")
	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Rule withCondition(Condition condition) {
		this.condition = condition;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("message", message).append("condition", condition).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(message).append(condition).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Rule) == false) {
			return false;
		}
		Rule rhs = ((Rule) other);
		return new EqualsBuilder().append(message, rhs.message).append(condition, rhs.condition).isEquals();
	}

}
