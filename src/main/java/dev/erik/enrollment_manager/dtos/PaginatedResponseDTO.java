package dev.erik.enrollment_manager.dtos;

import java.util.List;

public record PaginatedResponseDTO<T>(
    List<T> content,
    int currentPage,
    long totalItems,
    int totalPages) {
}
