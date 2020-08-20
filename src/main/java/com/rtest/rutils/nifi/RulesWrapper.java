package com.rtest.rutils.nifi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "rules" })
public class RulesWrapper implements Serializable {

	@JsonProperty("rules")
	private List<Rule> rules = new ArrayList<Rule>();
	private final static long serialVersionUID = -2107157953190897559L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RulesWrapper() {
	}

	/**
	 *
	 * @param rules
	 */
	public RulesWrapper(List<Rule> rules) {
		super();
		this.rules = rules;
	}

	@JsonProperty("rules")
	public List<Rule> getRules() {
		return rules;
	}

	@JsonProperty("rules")
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public RulesWrapper withRules(List<Rule> rules) {
		this.rules = rules;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("rules", rules).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(rules).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof RulesWrapper) == false) {
			return false;
		}
		RulesWrapper rhs = ((RulesWrapper) other);
		return new EqualsBuilder().append(rules, rhs.rules).isEquals();
	}

}