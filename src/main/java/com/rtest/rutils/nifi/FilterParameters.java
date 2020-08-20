package com.rtest.rutils.nifi;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "filterLHSParam", "filterOperatorParam", "filterCompareWithParam", "filterRHSParam" })
public class FilterParameters implements Serializable {

	@JsonProperty("filterLHSParam")
	private String filterLHSParam;
	@JsonProperty("filterOperatorParam")
	private String filterOperatorParam;
	@JsonProperty("filterCompareWithParam")
	private String filterCompareWithParam;
	@JsonProperty("filterRHSParam")
	private String filterRHSParam;
	private final static long serialVersionUID = 1104772952501720784L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public FilterParameters() {
	}

	/**
	 *
	 * @param filterRHSParam
	 * @param filterCompareWithParam
	 * @param filterOperatorParam
	 * @param filterLHSParam
	 */
	public FilterParameters(String filterLHSParam, String filterOperatorParam, String filterCompareWithParam,
			String filterRHSParam) {
		super();
		this.filterLHSParam = filterLHSParam;
		this.filterOperatorParam = filterOperatorParam;
		this.filterCompareWithParam = filterCompareWithParam;
		this.filterRHSParam = filterRHSParam;
	}

	@JsonProperty("filterLHSParam")
	public String getFilterLHSParam() {
		return filterLHSParam;
	}

	@JsonProperty("filterLHSParam")
	public void setFilterLHSParam(String filterLHSParam) {
		this.filterLHSParam = filterLHSParam;
	}

	public FilterParameters withFilterLHSParam(String filterLHSParam) {
		this.filterLHSParam = filterLHSParam;
		return this;
	}

	@JsonProperty("filterOperatorParam")
	public String getFilterOperatorParam() {
		return filterOperatorParam;
	}

	@JsonProperty("filterOperatorParam")
	public void setFilterOperatorParam(String filterOperatorParam) {
		this.filterOperatorParam = filterOperatorParam;
	}

	public FilterParameters withFilterOperatorParam(String filterOperatorParam) {
		this.filterOperatorParam = filterOperatorParam;
		return this;
	}

	@JsonProperty("filterCompareWithParam")
	public String getFilterCompareWithParam() {
		return filterCompareWithParam;
	}

	@JsonProperty("filterCompareWithParam")
	public void setFilterCompareWithParam(String filterCompareWithParam) {
		this.filterCompareWithParam = filterCompareWithParam;
	}

	public FilterParameters withFilterCompareWithParam(String filterCompareWithParam) {
		this.filterCompareWithParam = filterCompareWithParam;
		return this;
	}

	@JsonProperty("filterRHSParam")
	public String getFilterRHSParam() {
		return filterRHSParam;
	}

	@JsonProperty("filterRHSParam")
	public void setFilterRHSParam(String filterRHSParam) {
		this.filterRHSParam = filterRHSParam;
	}

	public FilterParameters withFilterRHSParam(String filterRHSParam) {
		this.filterRHSParam = filterRHSParam;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("filterLHSParam", filterLHSParam)
				.append("filterOperatorParam", filterOperatorParam)
				.append("filterCompareWithParam", filterCompareWithParam).append("filterRHSParam", filterRHSParam)
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(filterCompareWithParam).append(filterRHSParam).append(filterOperatorParam)
				.append(filterLHSParam).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof FilterParameters) == false) {
			return false;
		}
		FilterParameters rhs = ((FilterParameters) other);
		return new EqualsBuilder().append(filterCompareWithParam, rhs.filterCompareWithParam)
				.append(filterRHSParam, rhs.filterRHSParam).append(filterOperatorParam, rhs.filterOperatorParam)
				.append(filterLHSParam, rhs.filterLHSParam).isEquals();
	}

}
