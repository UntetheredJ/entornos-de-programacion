import config from '../config'

class APIInvoke {
    async invokeGET(resource, queryParams) {

        queryParams = queryParams || []
        const queryString = queryParams.reduce((last, q, i) => last + `${i === 0 ? '?' : "&"}${q}`, '')

        const token = localStorage.getItem("token");
        let bearer;
        if (token === "") {
            bearer = "";
        } else {
            bearer = `${token}`;
        }

        const data = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'x-auth-token': bearer
            }
        }
        const url = `${config.api.baseURL}${resource}${queryString}`
        let response = (await (await fetch(url, data)).json())
        return response
    }

    async invokePUT(resource, body) {

        const token = localStorage.getItem("token");
        let bearer;
        if (token === "") {
            bearer = "";
        } else {
            bearer = `${token}`;
        }

        const data = {
            method: 'PUT',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json',
                'x-auth-token': bearer
            }
        }
        const url = `${config.api.baseURL}${resource}`
        let response = (await (await fetch(url, data)).json())
        return response
    }

    async invokePOST(resource, body) {

        const token = localStorage.getItem("token");
        let bearer;
        if (token === "") {
            bearer = "";
        } else {
            bearer = `${token}`;
        }

        const data = {
            method: 'POST',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json',
                'x-auth-token': bearer
            }
        }
        const url = `${config.api.baseURL}${resource}`
        let response = (await (await fetch(url, data)).json())
        return response
    }

    async invokeDELETE(resource) {
        const token = localStorage.getItem("token");
        const bearer = token ? `${token}` : "";
    
        const data = {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'x-auth-token': bearer
            }
        }
    
        const url = `${config.api.baseURL}${resource}`;
        const response = await fetch(url, data);
    
        // Check if the response status indicates success or failure
        if (response.ok) { // status in the range 200-299
            // Try to parse JSON only if there is a response body
            const responseText = await response.text();
            const message = responseText ? JSON.parse(responseText) : "Deleted successfully";
            return { success: true, message };
        } else {
            // Try to parse the error message or return a default error
            const responseText = await response.text();
            const errorMessage = responseText ? JSON.parse(responseText) : "Failed to delete resource";
            return { success: false, message: errorMessage };
        }
    }
    
}

// eslint-disable-next-line import/no-anonymous-default-export
export default new APIInvoke()