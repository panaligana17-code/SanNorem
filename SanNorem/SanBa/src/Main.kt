class GeoCoordinate(
    val latitude: Double,
    val longitude: Double
)

abstract class BaseRetailBranch(
    val branchId: String,
    val branchName: String,
    val location: GeoCoordinate,
    val operatingHours: String,
    val baseRadiusKm: Double
){
    abstract fun calculateServiceArea(): List<GeoCoordinate>
    open fun isWithinBaseRadius(userLocation: GeoCoordinate): Boolean {
        return true
    }
}

class SevenElevenBranch(
    branchId: String,
    branchName: String,
    location: GeoCoordinate,
    operatingHours: String = "24/7",
    baseRadiusKm: Double = 3.0,
    val hasATm: Boolean,
    val hasCliqqKiosk: Boolean,
    val is247: Boolean = true,
) : BaseRetailBranch(branchId, branchName, location, operatingHours, baseRadiusKm){
    override fun calculateServiceArea(): List<GeoCoordinate> {
        return listOf(location)
    }
}

class AlfamartBranch(
    branchId: String,
    branchName: String,
    location: GeoCoordinate,
    operatingHours: String = "",
    baseRadiusKm: Double = 1.5,
    val hasFreshFoodSection: Boolean,
): BaseRetailBranch(branchId, branchName, location, operatingHours, baseRadiusKm){
    override fun calculateServiceArea(): List<GeoCoordinate> {
        return listOf(location)
    }
}

class DaliBranch(
    branchId: String,
    branchName: String,
    location: GeoCoordinate,
    operatingHours: String = "7:00 AM - 9:00 PM",
    baseRadiusKm: Double = 0.8,
    val acceptsCreditCards: Boolean = true
): BaseRetailBranch(branchId, branchName, location, operatingHours, baseRadiusKm){
    override fun calculateServiceArea(): List<GeoCoordinate> {
        return listOf(location)
    }
}

