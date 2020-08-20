package com.rtest.rutils.nifi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "isGroup", "groupOperator", "hasFilterCondition", "parameters", "filterParameters", "conditions" })
public class Condition implements Serializable {

	@JsonProperty("isGroup")
	private String isGroup;
	@JsonProperty("groupOperator")
	private String groupOperator;
	@JsonProperty("hasFilterCondition")
	private Boolean hasFilterCondition;
	@JsonProperty("parameters")
	private Parameters parameters;
	@JsonProperty("filterParameters")
	private FilterParameters filterParameters;
	@JsonProperty("conditions")
	private List<Condition> conditions = new ArrayList<Condition>();
	private final static long serialVersionUID = -8538248203961583242L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Condition() {
	}

	/**
	 *
	 * @param groupOperator
	 * @param filterParameters
	 * @param hasFilterCondition
	 * @param isGroup
	 * @param conditions
	 * @param parameters
	 */
	public Condition(String isGroup, String groupOperator, Boolean hasFilterCondition, Parameters parameters,
			FilterParameters filterParameters, List<Condition> conditions) {
		super();
		this.isGroup = isGroup;
		this.groupOperator = groupOperator;
		this.hasFilterCondition = hasFilterCondition;
		this.parameters = parameters;
		this.filterParameters = filterParameters;
		this.conditions = conditions;
	}

	@JsonProperty("isGroup")
	public String getIsGroup() {
		return isGroup;
	}

	@JsonProperty("isGroup")
	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}

	public Condition withIsGroup(String isGroup) {
		this.isGroup = isGroup;
		return this;
	}

	@JsonProperty("groupOperator")
	public String getGroupOperator() {
		return groupOperator;
	}

	@JsonProperty("groupOperator")
	public void setGroupOperator(String groupOperator) {
		this.groupOperator = groupOperator;
	}

	public Condition withGroupOperator(String groupOperator) {
		this.groupOperator = groupOperator;
		return this;
	}

	@JsonProperty("hasFilterCondition")
	public Boolean getHasFilterCondition() {
		return hasFilterCondition;
	}

	@JsonProperty("hasFilterCondition")
	public void setHasFilterCondition(Boolean hasFilterCondition) {
		this.hasFilterCondition = hasFilterCondition;
	}

	public Condition withHasFilterCondition(Boolean hasFilterCondition) {
		this.hasFilterCondition = hasFilterCondition;
		return this;
	}

	@JsonProperty("parameters")
	public Parameters getParameters() {
		return parameters;
	}

	@JsonProperty("parameters")
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public Condition withParameters(Parameters parameters) {
		this.parameters = parameters;
		return this;
	}

	@JsonProperty("filterParameters")
	public FilterParameters getFilterParameters() {
		return filterParameters;
	}

	@JsonProperty("filterParameters")
	public void setFilterParameters(FilterParameters filterParameters) {
		this.filterParameters = filterParameters;
	}

	public Condition withFilterParameters(FilterParameters filterParameters) {
		this.filterParameters = filterParameters;
		return this;
	}

	@JsonProperty("conditions")
	public List<Condition> getConditions() {
		return conditions;
	}

	@JsonProperty("conditions")
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public Condition withConditions(List<Condition> conditions) {
		this.conditions = conditions;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isGroup", isGroup).append("groupOperator", groupOperator)
				.append("hasFilterCondition", hasFilterCondition).append("parameters", parameters)
				.append("filterParameters", filterParameters).append("conditions", conditions).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(groupOperator).append(filterParameters).append(hasFilterCondition)
				.append(isGroup).append(conditions).append(parameters).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Condition) == false) {
			return false;
		}
		Condition rhs = ((Condition) other);
		return new EqualsBuilder().append(groupOperator, rhs.groupOperator)
				.append(filterParameters, rhs.filterParameters).append(hasFilterCondition, rhs.hasFilterCondition)
				.append(isGroup, rhs.isGroup).append(conditions, rhs.conditions).append(parameters, rhs.parameters)
				.isEquals();
	}

}