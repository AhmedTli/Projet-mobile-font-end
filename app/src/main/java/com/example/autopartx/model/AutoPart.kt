package com.example.autopartx.model

import com.example.autopartx.R
import com.google.gson.annotations.SerializedName

data class AutoPart(

	@field:SerializedName("image")
	val image: Int? = null,

	@field:SerializedName("price")
	val price: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("partNumber")
	val partNumber: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("brand")
	val brand: String? = null
)
fun getListAutoParts(): List<AutoPart> {
	return listOf(
		AutoPart(
			image = R.drawable.brakepad,
			price = 100.0,
			name = "Brake Pad",
			partNumber = "BP1234",
			category = "Brakes",
			brand = "AutoBrand"
		),
		AutoPart(
			image = R.drawable.airfilter,
			price = 50.0,
			name = "Air Filter",
			partNumber = "AF5678",
			category = "Filters",
			brand = "FilterCo"
		),
		AutoPart(
			image = R.drawable.oilfilter,
			price = 25.0,
			name = "Oil Filter",
			partNumber = "OF9101",
			category = "Filters",
			brand = "OilMaster"
		),
		AutoPart(
			image = R.drawable.suspensionkit,
			price = 150.0,
			name = "Suspension Kit",
			partNumber = "SK2022",
			category = "Suspension",
			brand = "SuspensionPro"
		),
		AutoPart(
			image = R.drawable.headlight,
			price = 200.0,
			name = "Headlight Assembly",
			partNumber = "HL3033",
			category = "Lighting",
			brand = "BrightLights"
		),
				AutoPart(
				image = R.drawable.brakepad,
		price = 100.0,
		name = "Brake Pad",
		partNumber = "BP1234",
		category = "Brakes",
		brand = "AutoBrand"
	),
	AutoPart(
		image = R.drawable.airfilter,
		price = 50.0,
		name = "Air Filter",
		partNumber = "AF5678",
		category = "Filters",
		brand = "FilterCo"
	),
	AutoPart(
		image = R.drawable.oilfilter,
		price = 25.0,
		name = "Oil Filter",
		partNumber = "OF9101",
		category = "Filters",
		brand = "OilMaster"
	),
	AutoPart(
		image = R.drawable.suspensionkit,
		price = 150.0,
		name = "Suspension Kit",
		partNumber = "SK2022",
		category = "Suspension",
		brand = "SuspensionPro"
	),
	AutoPart(
		image = R.drawable.headlight,
		price = 200.0,
		name = "Headlight Assembly",
		partNumber = "HL3033",
		category = "Lighting",
		brand = "BrightLights"
	)
	)
}