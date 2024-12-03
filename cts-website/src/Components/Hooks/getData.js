import {useEffect, useState} from "react";
import axios from "axios";


export default function useGet(target) {
    const [response, setResponse] = useState(null);
    const [error, setError] = useState(null);

    useEffect(() => {
        if (response) {
            setResponse(null);
        }

        const abortController = new AbortController();

        async function loadData() {
            try {
                const rez = await axios.get(target);
                setResponse(rez);
            } catch (err) {
                setError(err);
            }
        }
        // noinspection JSIgnoredPromiseFromCall
        loadData();

        return () => {
            abortController.abort();
        }
    }, [target])

    return {response, error};
}