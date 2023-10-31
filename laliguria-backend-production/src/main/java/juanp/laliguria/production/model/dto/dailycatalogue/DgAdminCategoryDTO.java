package juanp.laliguria.production.model.dto.dailycatalogue;

import javax.persistence.Column;

import lombok.Value;

@Value
public class DgAdminCategoryDTO {

	@Column(name = "Id")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;
}
