package com.example.azurejavaexamples.DTOs;

import java.util.Arrays;

public record ImageDTO(String userId, String id, ImageDTO.ImagesCollection[] imagesCollection) {
    @Override
    public String toString() {
        return "ImageDTO{" +
                "id='" + id + '\'' +
                ", imagesCollection=" + Arrays.toString(imagesCollection) +
                '}';
    }

    public record ImagesCollection(ImageDTO.ImagesCollection.Image[] images, String imagesCollectionId, String timestamp) {
        @Override
        public String toString() {
            return "ImagesCollection{" +
                    "images=" + Arrays.toString(images) +
                    ", imagesCollectionId='" + imagesCollectionId + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    '}';
        }

        public record Image(String imageId, String url) {
            @Override
            public String toString() {
                return "Image{" +
                        "imageId='" + imageId + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }
    }

}
