package com.rtest.rutils.nifi;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "lhsParam", "operatorParam", "compareWithParam", "compareWithMasterParam", "rhsParam",
		"actionParam", "enrichCompareWithParam", "enrichFromMasterParam", "enrichLHSParam", "enrichRHSParam" })
public class Parameters implements Serializable {

	@JsonProperty("lhsParam")
	private String lhsParam;
	@JsonProperty("operatorParam")
	private String operatorParam;
	@JsonProperty("compareWithParam")
	private String compareWithParam;
	@JsonProperty("compareWithMasterParam")
	private String compareWithMasterParam;
	@JsonProperty("rhsParam")
	private String rhsParam;
	@JsonProperty("actionParam")
	private String actionParam;
	@JsonProperty("enrichCompareWithParam")
	private String enrichCompareWithParam;
	@JsonProperty("enrichFromMasterParam")
	private String enrichFromMasterParam;
	@JsonProperty("enrichLHSParam")
	private String enrichLHSParam;
	@JsonProperty("enrichRHSParam")
	private String enrichRHSParam;
	private final static long serialVersionUID = 4152872817104817558L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Parameters() {
	}

	/**
	 *
	 * @param rhsParam
	 * @param enrichLHSParam
	 * @param enrichFromMasterParam
	 * @param operatorParam
	 * @param enrichRHSParam
	 * @param compareWithParam
	 * @param enrichCompareWithParam
	 * @param actionParam
	 * @param compareWithMasterParam
	 * @param lhsParam
	 */
	public Parameters(String lhsParam, String operatorParam, String compareWithParam, String compareWithMasterParam,
			String rhsParam, String actionParam, String enrichCompareWithParam, String enrichFromMasterParam,
			String enrichLHSParam, String enrichRHSParam) {
		super();
		this.lhsParam = lhsParam;
		this.operatorParam = operatorParam;
		this.compareWithParam = compareWithParam;
		this.compareWithMasterParam = compareWithMasterParam;
		this.rhsParam = rhsParam;
		this.actionParam = actionParam;
		this.enrichCompareWithParam = enrichCompareWithParam;
		this.enrichFromMasterParam = enrichFromMasterParam;
		this.enrichLHSParam = enrichLHSParam;
		this.enrichRHSParam = enrichRHSParam;
	}

	@JsonProperty("lhsParam")
	public String getLhsParam() {
		return lhsParam;
	}

	@JsonProperty("lhsParam")
	public void setLhsParam(String lhsParam) {
		this.lhsParam = lhsParam;
	}

	public Parameters withLhsParam(String lhsParam) {
		this.lhsParam = lhsParam;
		return this;
	}

	@JsonProperty("operatorParam")
	public String getOperatorParam() {
		return operatorParam;
	}

	@JsonProperty("operatorParam")
	public void setOperatorParam(String operatorParam) {
		this.operatorParam = operatorParam;
	}

	public Parameters withOperatorParam(String operatorParam) {
		this.operatorParam = operatorParam;
		return this;
	}

	@JsonProperty("compareWithParam")
	public String getCompareWithParam() {
		return compareWithParam;
	}

	@JsonProperty("compareWithParam")
	public void setCompareWithParam(String compareWithParam) {
		this.compareWithParam = compareWithParam;
	}

	public Parameters withCompareWithParam(String compareWithParam) {
		this.compareWithParam = compareWithParam;
		return this;
	}

	@JsonProperty("compareWithMasterParam")
	public String getCompareWithMasterParam() {
		return compareWithMasterParam;
	}

	@JsonProperty("compareWithMasterParam")
	public void setCompareWithMasterParam(String compareWithMasterParam) {
		this.compareWithMasterParam = compareWithMasterParam;
	}

	public Parameters withCompareWithMasterParam(String compareWithMasterParam) {
		this.compareWithMasterParam = compareWithMasterParam;
		return this;
	}

	@JsonProperty("rhsParam")
	public String getRhsParam() {
		return rhsParam;
	}

	@JsonProperty("rhsParam")
	public void setRhsParam(String rhsParam) {
		this.rhsParam = rhsParam;
	}

	public Parameters withRhsParam(String rhsParam) {
		this.rhsParam = rhsParam;
		return this;
	}

	@JsonProperty("actionParam")
	public String getActionParam() {
		return actionParam;
	}

	@JsonProperty("actionParam")
	public void setActionParam(String actionParam) {
		this.actionParam = actionParam;
	}

	public Parameters withActionParam(String actionParam) {
		this.actionParam = actionParam;
		return this;
	}

	@JsonProperty("enrichCompareWithParam")
	public String getEnrichCompareWithParam() {
		return enrichCompareWithParam;
	}

	@JsonProperty("enrichCompareWithParam")
	public void setEnrichCompareWithParam(String enrichCompareWithParam) {
		this.enrichCompareWithParam = enrichCompareWithParam;
	}

	public Parameters withEnrichCompareWithParam(String enrichCompareWithParam) {
		this.enrichCompareWithParam = enrichCompareWithParam;
		return this;
	}

	@JsonProperty("enrichFromMasterParam")
	public String getEnrichFromMasterParam() {
		return enrichFromMasterParam;
	}

	@JsonProperty("enrichFromMasterParam")
	public void setEnrichFromMasterParam(String enrichFromMasterParam) {
		this.enrichFromMasterParam = enrichFromMasterParam;
	}

	public Parameters withEnrichFromMasterParam(String enrichFromMasterParam) {
		this.enrichFromMasterParam = enrichFromMasterParam;
		return this;
	}

	@JsonProperty("enrichLHSParam")
	public String getEnrichLHSParam() {
		return enrichLHSParam;
	}

	@JsonProperty("enrichLHSParam")
	public void setEnrichLHSParam(String enrichLHSParam) {
		this.enrichLHSParam = enrichLHSParam;
	}

	public Parameters withEnrichLHSParam(String enrichLHSParam) {
		this.enrichLHSParam = enrichLHSParam;
		return this;
	}

	@JsonProperty("enrichRHSParam")
	public String getEnrichRHSParam() {
		return enrichRHSParam;
	}

	@JsonProperty("enrichRHSParam")
	public void setEnrichRHSParam(String enrichRHSParam) {
		this.enrichRHSParam = enrichRHSParam;
	}

	public Parameters withEnrichRHSParam(String enrichRHSParam) {
		this.enrichRHSParam = enrichRHSParam;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("lhsParam", lhsParam).append("operatorParam", operatorParam)
				.append("compareWithParam", compareWithParam).append("compareWithMasterParam", compareWithMasterParam)
				.append("rhsParam", rhsParam).append("actionParam", actionParam)
				.append("enrichCompareWithParam", enrichCompareWithParam)
				.append("enrichFromMasterParam", enrichFromMasterParam).append("enrichLHSParam", enrichLHSParam)
				.append("enrichRHSParam", enrichRHSParam).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(rhsParam).append(enrichLHSParam).append(enrichFromMasterParam)
				.append(operatorParam).append(enrichRHSParam).append(compareWithParam).append(enrichCompareWithParam)
				.append(actionParam).append(compareWithMasterParam).append(lhsParam).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Parameters) == false) {
			return false;
		}
		Parameters rhs = ((Parameters) other);
		return new EqualsBuilder().append(rhsParam, rhs.rhsParam).append(enrichLHSParam, rhs.enrichLHSParam)
				.append(enrichFromMasterParam, rhs.enrichFromMasterParam).append(operatorParam, rhs.operatorParam)
				.append(enrichRHSParam, rhs.enrichRHSParam).append(compareWithParam, rhs.compareWithParam)
				.append(enrichCompareWithParam, rhs.enrichCompareWithParam).append(actionParam, rhs.actionParam)
				.append(compareWithMasterParam, rhs.compareWithMasterParam).append(lhsParam, rhs.lhsParam).isEquals();
	}

}
