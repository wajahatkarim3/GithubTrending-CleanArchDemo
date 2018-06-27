package com.wajahatkarim.githtrending_clean.model

data class ProjectModel (val id: String, val name: String, val fullName: String,
                         val starCount: String, val dateCreated: String,
                         val ownerName: String, val ownerAvatar: String,
                         val isBookmaked: Boolean)