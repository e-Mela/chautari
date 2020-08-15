package org.emela.chautari.mapper;

import org.emela.chautari.domain.ReviewEntity;
import org.emela.chautari.model.Review;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface ReviewEntityMapper {

    ReviewEntityMapper INSTANCE = Mappers.getMapper(ReviewEntityMapper.class);


    @Mapping(target = "reviewId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "rental", ignore = true)
    @Mapping(target = "lastUpdatedUser", ignore = true)
    @Mapping(target = "lastUpdatedOn", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdUser", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    ReviewEntity mapToReviewEntity(Review review);

    @InheritInverseConfiguration
    Review mapToReview(ReviewEntity reviewEntity);
}
