db.createUser(
    {
        user: "app-docker",
        pwd: "Mongo123",
        roles: [
            {
                role: "readWrite",
                db: "app-docker"
            }
        ]
    }
)