"use client"

import { createContext, useContext, useState } from "react"

const LoadingContext = createContext({
  loading: false,
  setLoading: (value: boolean) => {}
})

export function LoadingProvider({ children }: { children: React.ReactNode }) {
  const [loading, setLoading] = useState(false)

  return (
    <LoadingContext.Provider value={{ loading, setLoading }}>
      {children}
      {loading && (
        <div className="fixed inset-0 bg-black/40 flex items-center justify-center z-50">
          <div className="animate-spin rounded-full h-12 w-12 border-4 border-blue-400 border-t-transparent" />
        </div>
      )}
    </LoadingContext.Provider>
  )
}

export const useLoading = () => useContext(LoadingContext)