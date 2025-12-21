@Override
protected boolean shouldNotFilter(HttpServletRequest request) {
    String path = request.getServletPath();
    return path.startsWith("/auth/")
        || path.startsWith("/swagger-ui")
        || path.startsWith("/v3/api-docs");
}
